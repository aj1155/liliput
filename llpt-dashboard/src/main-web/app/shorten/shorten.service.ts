import { Injectable } from '@angular/core';
import { RequestHandler } from '../shared/handlers/requestHandler';

import { SHORTEN_URL } from '../shared/constants/index';
import { Shorten } from "./model/shorten";

@Injectable()
export class ShortenService {
  constructor(private requestHandler:RequestHandler) {
  }

  createShorten(originUrl:string) {
    let data = {
      'originUrl' : originUrl
    };
    return this.requestHandler.post(SHORTEN_URL, data);
  }
}
