import { Component, OnInit, ViewEncapsulation, OnDestroy } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-entry',
  templateUrl: './app.html',
  styleUrls: ['./shared/styles/app.global.scss', './app.scss'],
  providers: [],
  encapsulation: ViewEncapsulation.None
})

export class AppComponent implements OnInit, OnDestroy {

  private errorMessage:string;

  constructor(private titleService:Title) {
  }

  ngOnInit() {
    this.titleService.setTitle('Dashboard Main Page');
  }

  ngOnDestroy() {

  }
}
