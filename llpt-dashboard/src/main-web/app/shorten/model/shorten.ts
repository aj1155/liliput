export class Shorten {
  createdDate:string;
  lastModifiedDate:string;
  id:string;
  domain:string;
  path:string;
  originUrl:string;

  constructor(shorten:{}) {
    this.createdDate = shorten['createdDate'];
    this.lastModifiedDate = shorten['lastModifiedDate'];
    this.id = shorten['id'];
    this.domain = shorten['domain'];
    this.path = shorten['path'];
    this.originUrl = shorten['originUrl'];
  }
}
