import { NgModule } from '@angular/core';

import { ShortenComponent }   from './shorten.component';
import { ShortenService } from "./shorten.service";
import { FormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@NgModule({
  imports: [CommonModule, FormsModule],
  providers: [ShortenService],
  declarations: [ShortenComponent],
  exports: [ShortenComponent]
})
export class ShortenModule {
}
