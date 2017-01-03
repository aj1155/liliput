import { Injectable } from '@angular/core';
import { EventEmitter } from '@angular/common/src/facade/async';

@Injectable()
export class GlobalEventsManager {

  showHeader:EventEmitter<boolean> = new EventEmitter();
  showLogout:EventEmitter<boolean> = new EventEmitter();

  constructor() {
  }

  showCommonStructures() {
    this.showHeader.emit(true);
    this.showLogout.emit(true);
  }

  hideCommonStructures() {
    this.showHeader.emit(false);
    this.showLogout.emit(false);
  }
}
