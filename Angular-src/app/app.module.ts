import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmpComponent } from './emp/emp.component';
import { SummaryPipe } from './summary.pipe';
import { CasestudiesComponent } from './casestudies/casestudies.component';
import { CustomersComponent } from './customers/customers.component';
import { AboutComponent } from './about/about.component';
import { HighlightDirective } from './highlight.directive';

@NgModule({
  declarations: [
    AppComponent,
    EmpComponent,
    SummaryPipe,
    CasestudiesComponent,
    CustomersComponent,
    AboutComponent,
    HighlightDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
