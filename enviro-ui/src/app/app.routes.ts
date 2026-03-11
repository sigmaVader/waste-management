import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { DashbordComponent } from './dashbord/dashbord.component';
import { WasteRecordComponent } from './waste-record/waste-record.component';
import { PickUpScheduleComponent } from './pickup-schedule/pickup-schedule.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },

  { path: 'register', component: RegisterComponent },
  {path:'dashbord', component:DashbordComponent},
  {path:'waste-record',component:WasteRecordComponent},
 { path: 'pickup-schedule', component: PickUpScheduleComponent }
];