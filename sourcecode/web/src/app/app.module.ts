import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgZorroAntdModule, NZ_I18N, zh_CN } from 'ng-zorro-antd';
import { AppComponent } from './app.component';

/** 配置 angular i18n **/
import { registerLocaleData } from '@angular/common';
import zh from '@angular/common/locales/zh';
import { PreloadAllModules, RouterModule } from '@angular/router';

import { routes } from './app.routing.module';
import { ShareModule } from './share/share.module';

import { environment } from '../environments/environment';

registerLocaleData(zh);

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    /** 导入 ng-zorro-antd 模块 **/
    NgZorroAntdModule,
    ShareModule,
    RouterModule.forRoot(routes, environment.production ? { preloadingStrategy: PreloadAllModules } : {})
  ],
  bootstrap: [ AppComponent ],
  /** 配置 ng-zorro-antd 国际化 **/
  providers   : [ { provide: NZ_I18N, useValue: zh_CN } ]
})
export class AppModule {

}
