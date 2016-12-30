import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';

import { RequestExceptionHandler } from './requestExceptionHandler';

@Injectable()
export class RequestHandler {
  constructor(private requestExceptionHandler:RequestExceptionHandler, private http:Http) {
  }

  get(url:string) {

    return this.http.get(url, this.getCommonOptions())
      .map(res => res.json())
      .catch(this.requestExceptionHandler.handleError);
  }

  post(url:string, body:any) {

    return this.http.post(url, JSON.stringify(body), this.getCommonOptions())
      .map(res => res.json())
      .catch(this.requestExceptionHandler.handleError);
  }

  put(url:string, body:any) {

    return this.http.put(url, JSON.stringify(body), this.getCommonOptions())
      .map(res => res.json())
      .catch(this.requestExceptionHandler.handleError);
  }

  delete(url:string) {

    return this.http.delete(url, this.getCommonOptions())
      .map(res => res.json())
      .catch(this.requestExceptionHandler.handleError);
  }

  private getCommonOptions():RequestOptions {

    const headers = new Headers({'Content-Type': 'application/json'});
    return new RequestOptions({headers: headers, withCredentials: true});
  }
}
