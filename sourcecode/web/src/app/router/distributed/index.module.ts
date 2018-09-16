import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {ZookeeperComponent} from "./zookeeper/zookeeper.component";
import {DistributedIndexComponent} from "./index.component";
import {ShareModule} from "../../share/share.module";
import {IntroduceComponent} from "./introduce/introduce.component";



@NgModule({
  imports     : [
    ShareModule,
    RouterModule.forChild([
      {
        path:'index', component: DistributedIndexComponent,
        children:[
          {
            path: '',
            pathMatch: 'full',
            redirectTo: 'introduce'
          },
          {
            path:'introduce',
            component: IntroduceComponent,
          },
          {
            path:'zookeeper',
            component: ZookeeperComponent,
          }
        ]
      }
    ])
  ],
  declarations: [
    DistributedIndexComponent,
    ZookeeperComponent,
    IntroduceComponent

  ]
})
export class DistributedModule {

}
