const webpack = require('webpack');
const helpers = require('./helpers');
const path = require('path');

// problem with copy-webpack-plugin
var CopyWebpackPlugin = (CopyWebpackPlugin = require('copy-webpack-plugin'), CopyWebpackPlugin.default || CopyWebpackPlugin);
const HtmlWebpackPlugin = require('html-webpack-plugin');

const ENV = process.env.NODE_ENV;
if (ENV !== 'local' && ENV !== 'local-server' && ENV !== 'dev' && ENV !== 'alpha' && ENV !== 'prod') {
  throw new Error('NODE_ENV must be specified (local or dev or prod)');
}
const METADATA = {
  host: 'localhost',
  port: 3000,
  ENV: ENV
};

module.exports = {
  'metadata': METADATA,
  'core': {
    cache: true,
    entry: {
      'polyfills': './src/main-web/polyfills.ts',
      'vendor': './src/main-web/vendor.ts',
      'main': './src/main-web/main.ts'
    },
    performance: {
      hints: false
    },
    stats: {
      // colors: true,
      // modules: true,
      // reasons: true,
      // errorDetails: true,
      //
      // hash: true,
      // version: true,
      // timings: true,
      // assets: true,
      // chunks: true,
      // reasons: false,
      // children: false,
      // source: false,
      // errors: false,
      // warnings: false,
      // publicPath: false
    },
    resolve: {
      unsafeCache: true,
      extensions: ['.ts', '.js', '.json', '.css', '.scss', '.html'],
      modules: ['node_modules', helpers.root('./src/main-web')]
    },
    module: {
      noParse: [
        /es6-shim/,
        /reflect-metadata/,
        /zone\.js(\/|\\)dist(\/|\\)zone-microtask/
      ],
      rules: [
        {test: /\.ts$/, use: 'tslint-loader', enforce: 'pre', exclude: [helpers.root('node_modules')]},
        {
          test: /\.ts$/,
          use: ['awesome-typescript-loader', 'angular2-template-loader'],
          exclude: [/node_modules\/(?!(ng2-.+))/]
        },
        {
          test: /\.json$/,
          use: 'json-loader'
        },
        {test: /\.scss$/, use: ['raw-loader', 'sass-loader']},
        {
          test: /\.html$/,
          use: 'raw-loader'
        }
      ]
    },
    devServer: {
      port: METADATA.port,
      host: METADATA.host,
      historyApiFallback: true,
      stats: 'normal',
      watchOptions: {
        aggregateTimeout: 300,
        poll: 1000
      }
    },

    plugins: [
      new webpack.ContextReplacementPlugin(
        // The (\\|\/) piece accounts for path separators in *nix and Windows
        /angular(\\|\/)core(\\|\/)(esm(\\|\/)src|src)(\\|\/)linker/,
        helpers.root('./src/main-web')
      ),
      new webpack.optimize.OccurrenceOrderPlugin(true),

      new webpack.optimize.CommonsChunkPlugin({
        name: ['polyfills', 'vendor'].reverse()
      }),

      new CopyWebpackPlugin([
        {from: 'src/imgs', to: 'imgs'},
        {from: 'src/fonts', to: 'fonts'}
      ]),
      new HtmlWebpackPlugin({
        template: 'src/views/index.html',
        chunksSortMode: 'dependency'
      })
    ],
    node: {
      global: true,
      process: true,
      crypto: 'empty',
      module: false,
      clearImmediate: false,
      setImmediate: false
    }
  }
};
