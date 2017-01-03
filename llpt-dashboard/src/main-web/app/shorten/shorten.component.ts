import { Component, OnInit } from '@angular/core';
import { Shorten } from './model/shorten';
import { ShortenService } from './shorten.service';

@Component({
  selector:'llpt-shorten',
  templateUrl:'./shorten.html',
  styleUrls:['shorten.scss']
})
export class ShortenComponent implements OnInit {
  originUrl:string;
  shortenResult:Shorten;

  constructor(private shortenService:ShortenService) {
  }

  ngOnInit() {
  }

  shorten() {
    this.shortenService.createShorten(this.originUrl).subscribe(data => {
      this.shortenResult = data.result.shortUrl;
    })
  }
}
