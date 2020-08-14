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
<<<<<<< HEAD
import { MatButtonModule } from '@angular/material/button';
=======
import { MatSliderModule } from '@angular/material/slider';
import { MatCardModule} from '@angular/material/card';
import { MatButtonModule} from '@angular/material/button';

>>>>>>> c7f3ccfe96f2f21e7681c2b0fda9a51e4b16f2cc
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
<<<<<<< HEAD
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
  ],
=======
  imports: [BrowserModule, 
    AppRoutingModule, 
    BrowserAnimationsModule, 
    MatSliderModule,
    MatCardModule,
    MatButtonModule],
    
>>>>>>> c7f3ccfe96f2f21e7681c2b0fda9a51e4b16f2cc
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
