import { InMemoryDbService } from 'angular-in-memory-web-api/index';

export class InMemoryMockDbService implements InMemoryDbService {
  createDb() {
    return {
      'api/v1/shorten/url': require('./shorten/shorten-response.json'),
      'api/v1/shorten/url/all': require('./shorten/shorten-list-response.json')
    };
  }
}
