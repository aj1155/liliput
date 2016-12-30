import { browser } from 'protractor';

describe('App', () => {

  beforeEach(() => {
    browser.get('/');
  });

  it('should have a title', () => {
    const subject = browser.getTitle();
    const result  = 'Dashboard Main Page';
    expect(subject).toEqual(result);
  });
});
