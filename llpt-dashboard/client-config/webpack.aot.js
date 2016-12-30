const webpack = require('webpack');
const helpers = require('./helpers');
const webpackMerge = require('webpack-merge'); // used to merge webpack configs
var CopyWebpackPlugin = (CopyWebpackPlugin = require('copy-webpack-plugin'), CopyWebpackPlugin.default || CopyWebpackPlugin);
const HtmlWebpackPlugin = require('html-webpack-plugin');
const commonConfig = require('./webpack.common.js'); // the settings that are common to prod and dev

const ngtools = require('@ngtools/webpack');

const path = require('path');

/**
 * Webpack Plugins
 */
const DefinePlugin = require('webpack/lib/DefinePlugin');
const DedupePlugin = require('webpack/lib/optimize/DedupePlugin');
const UglifyJsPlugin = require('webpack/lib/optimize/UglifyJsPlugin');

module.exports = webpackMerge(commonConfig.core, {

  devtool: 'source-map',
  entry: {
    'polyfills': './src/main-web/polyfills.ts',
    'vendor': './src/main-web/vendor.ts',
    'main.aot': './src/main-web/main.ts'
  },
  output: {
    path: helpers.root('./dist'),
    filename: 'main-web/app/[name].bundle.js',
    sourceMapFilename: 'main-web/app/[name].bundle.map',
    chunkFilename: 'main-web/app/[id].chunk.js'
  },
  resolve: {
    unsafeCache: true,
    extensions: ['.ts', '.js', '.json', '.css', '.scss', '.html'],
    modules: ['node_modules', helpers.root('./src/main-web') ]
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
        use: ['awesome-typescript-loader', 'angular2-template-loader', '@ngtools/webpack'],
        exclude: [/node_modules\/(?!(ng2-.+))/]
      },
      {
        test: /\.json$/,
        use: 'json-loader'
      },
      {test: /\.scss$/, use: ['raw-loader', 'sass-loader']},
      {test: /\.css$/, use: 'css-loader'},

      {
        test: /\.html$/,
        use: 'html-loader',
        query: {
          minimize: true,
          ignoreCustomFragments: [/\{\{.*?}}/],
          removeAttributeQuotes: false,
          caseSensitive: true,
          customAttrSurround: [ [/#/, /(?:)/], [/\*/, /(?:)/], [/\[?\(?/, /(?:)/] ],
          customAttrAssign: [ /\)?\]?=/ ]
        }
      }
    ]
  },
  plugins: [
    new webpack.ProgressPlugin(),
    new webpack.optimize.OccurrenceOrderPlugin(true),
    new ngtools.AotPlugin({
      tsConfigPath: './tsconfig.aot.json',
      baseDir: path.resolve(__dirname, ''),
      entryModule: '.src/main-web/app/app.module#AppModule'
    }),
    new webpack.ContextReplacementPlugin(
      // The (\\|\/) piece accounts for path separators in *nix and Windows
      /angular(\\|\/)core(\\|\/)(esm(\\|\/)src|src)(\\|\/)linker/,
      helpers.root('./src/main-web')
    ),
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
    }),
    new webpack.LoaderOptionsPlugin({
      debug: true
      // minimise: true
    }),
    new webpack.DefinePlugin({
      'process.env.NODE_ENV': JSON.stringify(commonConfig.metadata.ENV)
    }),

    new UglifyJsPlugin({
      beautify: false, //prod
      mangle: {
        screw_ie8: true,
        keep_fnames: true
      }, //prod
      compress: {
        warnings: false,
        screw_ie8: true
      }, //prod
      comments: false, //prod
      drop_debugger: true,
      drop_console: true,
      unsafe: true
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
})
;
