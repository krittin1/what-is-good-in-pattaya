import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavComponent } from './nav/nav.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { EditComponent } from './edit/edit.component';
import { HistoryComponent } from './history/history.component';
import { FormComponent } from './form/form.component';
import { SubmitComponent } from './submit/submit.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [
    AppComponent,


    NavComponent,
    LoginComponent,
    MenuComponent,
    EditComponent,
    HistoryComponent,
    FormComponent,
    SubmitComponent,
    
  ],
  imports: [BrowserModule, AppRoutingModule, BrowserAnimationsModule, MatSliderModule,MatCardModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
