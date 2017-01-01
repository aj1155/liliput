// DEFAULT URL must be different depending on local or dev or prod
const ENV = process.env.NODE_ENV;

const VERSION_PREFIX = 'v1/';
const API_PREFIX = 'api/' + VERSION_PREFIX;
const DEFAULT_IN_MEMORY_API_URL = 'http://localhost:3000/app/' + API_PREFIX;

// RNB API URL
let defaultDashboardApiUrl = DEFAULT_IN_MEMORY_API_URL;

if (ENV === 'local-server') {
  defaultDashboardApiUrl = 'http://localhost:8080/' + API_PREFIX;
} else if (ENV === 'dev') {
  defaultDashboardApiUrl = 'http://222.239.249.195:8080/list-api/' + API_PREFIX;
} else if (ENV === 'alpha') {
  defaultDashboardApiUrl = 'http://localhost:8080/' + API_PREFIX;
} else if (ENV === 'prod') {
  defaultDashboardApiUrl = 'http://localhost:8080/' + API_PREFIX;
}
export const DEFAULT_DASHBOARD_API_URL = defaultDashboardApiUrl;  // URL to web api

export const SHORTEN_URL = DEFAULT_DASHBOARD_API_URL + 'shorten/url';
export const SHORTEN_LIST_URL = DEFAULT_DASHBOARD_API_URL + 'shorten/url/all';