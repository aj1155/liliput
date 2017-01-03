import { NgModule, Type, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpModule } from '@angular/http';
import { BrowserModule, Title } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { InMemoryWebApiModule } from 'angular-in-memory-web-api';

import { AppRoutingModule } from './app.routing.module';
import { AppComponent } from './app.component';
import { InMemoryOverrideMockDbService } from './shared/mock-data/in-memory-override-mock-db.service';

import { HomeModule } from './home/home.module';
import { ShortenModule } from './shorten/shorten.module';

import { RequestHandler, RequestExceptionHandler } from './shared/handlers';
import { AppService } from './app.service';
import { GlobalEventsManager } from './shared/events/global-events-manager';

let modules:Array<Type<any> | ModuleWithProviders | any[]> = [BrowserModule, CommonModule, HttpModule, FormsModule,
  ReactiveFormsModule, AppRoutingModule, HomeModule, ShortenModule];

if (process.env.NODE_ENV === 'local') {
  modules.push(InMemoryWebApiModule.forRoot(InMemoryOverrideMockDbService, {delay: 100, passThruUnknownUrl: true}));
}

@NgModule({
  imports: modules,
  providers: [Title, RequestHandler, RequestExceptionHandler, GlobalEventsManager, AppService],
  declarations: [AppComponent],
  bootstrap: [AppComponent]
})

/***
 * 공통적으로 쓰일 Module 또는 Dependency Injection성 service들은 여기서 등록을 한다.
 * NODE_ENV환경에 따라서 in-memory-db 사용 유무가 다르니 주의
 */
export class AppModule {
}
