import { Injectable } from '@angular/core';
import { EventEmitter } from '@angular/common/src/facade/async';

@Injectable()
export class GlobalEventsManager {
  userName:EventEmitter<string> = new EventEmitter();

  constructor() {
  }
}
