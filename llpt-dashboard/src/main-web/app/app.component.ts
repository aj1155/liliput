import { Component, OnInit, ViewEncapsulation, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';

import { GlobalEventsManager } from './shared/events/global-events-manager';

@Component({
  selector: 'app-entry',
  templateUrl: './app.html',
  styleUrls: ['./shared/styles/app.global.scss', './app.scss'],
  providers: [],
  encapsulation: ViewEncapsulation.None
})

export class AppComponent implements OnInit, OnDestroy {

  private errorMessage:string;

  userName:string = 'nexters';

  showHeader:boolean = true;
  showLogout:boolean = true;

  constructor(private titleService:Title, private globalEventsManager:GlobalEventsManager) {
  }

  ngOnInit() {
    this.titleService.setTitle('Dashboard Main Page');
    this.globalEventsManager.showHeader.subscribe(mod => {
      this.showHeader = mod;
    }, error => this.errorMessage = <any>error);
    this.globalEventsManager.showLogout.subscribe(mod => {
      this.showHeader = mod;
    }, error => this.errorMessage = <any>error);
  }

  ngOnDestroy() {

  }

  logout() {
    alert('Logout..');
  }
}
