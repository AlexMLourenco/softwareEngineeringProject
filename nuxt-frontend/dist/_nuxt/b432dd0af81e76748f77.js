(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{341:function(t,e,r){"use strict";r.d(e,"a",(function(){return h})),r.d(e,"b",(function(){return v}));var n=r(1),o=r(342),l=r(344),c=r(6),f=l.a.extend({name:"v-card-media",mounted:function(){Object(c.d)("v-card-media",this.src?"v-img":"v-responsive",this)}}),d=r(0).a.extend({name:"v-card-title",functional:!0,props:{primaryTitle:Boolean},render:function(t,e){var data=e.data,r=e.props,n=e.children;return data.staticClass=("v-card__title "+(data.staticClass||"")).trim(),r.primaryTitle&&(data.staticClass+=" v-card__title--primary"),t("div",data,n)}}),h=Object(n.e)("v-card__actions"),v=Object(n.e)("v-card__text");o.a},355:function(t,e,r){var content=r(359);"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,r(5).default)("2513c6d2",content,!0,{sourceMap:!1})},356:function(t,e,r){var content=r(361);"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,r(5).default)("33093f2d",content,!0,{sourceMap:!1})},357:function(t,e,r){"use strict";r(11);var n={props:{fullWidth:{type:Boolean,default:!1},offset:{type:[Number,String],default:0}},computed:{classes:function(){return{"v-offset--full-width":this.fullWidth}},styles:function(){return{top:"-".concat(this.offset,"px"),marginBottom:"-".concat(this.offset,"px")}}}},o=(r(358),r(14)),l={inheritAttrs:!1,components:{helperOffset:Object(o.a)(n,(function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"v-offset",class:this.classes,style:this.styles},[this._t("default")],2)}),[],!1,null,null,null).exports},props:{color:{type:String,default:"secondary"},elevation:{type:[Number,String],default:10},inline:{type:Boolean,default:!1},fullWidth:{type:Boolean,default:!1},offset:{type:[Number,String],default:24},title:{type:String,default:void 0},text:{type:String,default:void 0}},computed:{hasOffset:function(){return this.$slots.header||this.$slots.offset||this.title||this.text},styles:function(){return this.hasOffset?{marginBottom:"".concat(this.offset,"px"),marginTop:"".concat(2*this.offset,"px")}:null}}},c=(r(360),r(35)),f=r.n(c),d=r(342),h=r(341),v=r(345),m=Object(o.a)(l,(function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("v-card",t._g(t._b({style:t.styles},"v-card",t.$attrs,!1),t.$listeners),[t.hasOffset?r("helper-offset",{attrs:{inline:t.inline,"full-width":t.fullWidth,offset:t.offset}},[t.$slots.offset?t._t("offset"):r("v-card",{staticClass:"v-card--material__header",class:"elevation-"+t.elevation,attrs:{color:t.color,dark:""}},[t.title||t.text?r("span",[r("h4",{staticClass:"title font-weight-light mb-2",domProps:{textContent:t._s(t.title)}}),t._v(" "),r("p",{staticClass:"category font-weight-thin",domProps:{textContent:t._s(t.text)}})]):t._t("header")],2)],2):t._e(),t._v(" "),r("v-card-text",[t._t("default")],2),t._v(" "),t.$slots.actions?r("v-divider",{staticClass:"mx-3"}):t._e(),t._v(" "),t.$slots.actions?r("v-card-actions",[t._t("actions")],2):t._e()],1)}),[],!1,null,null,null);e.a=m.exports;f()(m,{VCard:d.a,VCardActions:h.a,VCardText:h.b,VDivider:v.a})},358:function(t,e,r){"use strict";var n=r(355);r.n(n).a},359:function(t,e,r){(e=r(4)(!1)).push([t.i,".v-offset{margin:0 auto;max-width:calc(100% - 32px);position:relative}.v-offset--full-width{max-width:100%}",""]),t.exports=e},360:function(t,e,r){"use strict";var n=r(356);r.n(n).a},361:function(t,e,r){(e=r(4)(!1)).push([t.i,".v-card--material__header.v-card{border-radius:4px}",""]),t.exports=e},369:function(t,e,r){var content=r(381);"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,r(5).default)("04aaf4ea",content,!0,{sourceMap:!1})},380:function(t,e,r){"use strict";var n=r(369);r.n(n).a},381:function(t,e,r){(e=r(4)(!1)).push([t.i,".v-alert--notification{border-radius:4px!important;border-top:none!important}",""]),t.exports=e},382:function(t,e,r){var content=r(383);"string"==typeof content&&(content=[[t.i,content,""]]),content.locals&&(t.exports=content.locals);(0,r(5).default)("b619bfda",content,!0,{sourceMap:!1})},383:function(t,e,r){(e=r(4)(!1)).push([t.i,".v-alert{border-radius:0;border-width:4px 0 0;border-style:solid;color:#fff;display:flex;font-size:14px;margin:4px auto;padding:16px;position:relative;transition:.3s cubic-bezier(.25,.8,.5,1)}.v-alert .v-alert__icon.v-icon,.v-alert__dismissible .v-icon{align-self:center;color:rgba(0,0,0,.3);font-size:24px}.v-alert--outline .v-icon{color:inherit!important}.v-alert__icon{margin-right:16px}.v-alert__dismissible{align-self:flex-start;color:inherit;margin-left:16px;margin-right:0;text-decoration:none;transition:.3s cubic-bezier(.25,.8,.5,1);-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none}.v-alert__dismissible:hover{opacity:.8}.v-alert--no-icon .v-alert__icon{display:none}.v-alert>div{align-self:center;flex:1 1}@media screen and (max-width:600px){.v-alert__icon{display:none}}.v-alert.v-alert{border-color:rgba(0,0,0,.12)!important}.v-alert.v-alert--outline{border:1px solid!important}",""]),t.exports=e},409:function(t,e,r){"use strict";r.r(e);r(46);var n=r(12),o=r(77),l=r.n(o),c=r(357),f=(r(11),{inheritAttrs:!1,props:{elevation:{type:[Number,String],default:6},value:{type:Boolean,default:!0}}}),d=(r(380),r(14)),h=r(35),v=r.n(h),m=(r(23),r(36),r(382),r(45)),_=r(9),x=r(39),y=r(165),w=r(3),C=Object(w.a)(_.a,x.a,y.a).extend({name:"v-alert",props:{dismissible:Boolean,icon:String,outline:Boolean,type:{type:String,validator:function(t){return["info","error","success","warning"].includes(t)}}},computed:{computedColor:function(){return this.type&&!this.color?this.type:this.color||"error"},computedIcon:function(){if(this.icon||!this.type)return this.icon;switch(this.type){case"info":return"$vuetify.icons.info";case"error":return"$vuetify.icons.error";case"success":return"$vuetify.icons.success";case"warning":return"$vuetify.icons.warning"}}},methods:{genIcon:function(){return this.computedIcon?this.$createElement(m.a,{class:"v-alert__icon"},this.computedIcon):null},genDismissible:function(){var t=this;return this.dismissible?this.$createElement("a",{class:"v-alert__dismissible",on:{click:function(){t.isActive=!1}}},[this.$createElement(m.a,{props:{right:!0}},"$vuetify.icons.cancel")]):null}},render:function(t){var e=[this.genIcon(),t("div",this.$slots.default),this.genDismissible()],r=t("div",(this.outline?this.setTextColor:this.setBackgroundColor)(this.computedColor,{staticClass:"v-alert",class:{"v-alert--outline":this.outline},directives:[{name:"show",value:this.isActive}],on:this.$listeners}),e);return this.transition?t("transition",{props:{name:this.transition,origin:this.origin,mode:this.mode}},[r]):r}}),component=Object(d.a)(f,(function(){var t=this.$createElement;return(this._self._c||t)("v-alert",this._g(this._b({staticClass:"v-alert--notification",class:["elevation-"+this.elevation],attrs:{value:this.value}},"v-alert",this.$attrs,!1),this.$listeners),[this._t("default")],2)}),[],!1,null,null,null),$=component.exports;v()(component,{VAlert:C});var O={layout:"dashboard",components:{materialCard:c.a,materialNotification:$},data:function(){return{color:null,colors:["purple","info","success","warning","error"],top:!0,bottom:!1,left:!1,right:!1,snackbar:!1,notifications:[]}},methods:{snack:function(){this.top=!1,this.bottom=!1,this.left=!1,this.right=!1;for(var t=arguments.length,e=new Array(t),r=0;r<t;r++)e[r]=arguments[r];for(var n=0,o=e;n<o.length;n++){var l=o[n];this[l]=!0}this.color=this.colors[Math.floor(Math.random()*this.colors.length)],this.snackbar=!0},fetchAlarms:function(){var t=this;return Object(n.a)(regeneratorRuntime.mark((function e(){var r;return regeneratorRuntime.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,l.a.get(t.getUrl()+"/alarms/all");case 3:r=e.sent,t.notifications=r.data,e.next=10;break;case 7:e.prev=7,e.t0=e.catch(0),console.log(e.t0);case 10:case"end":return e.stop()}}),e,null,[[0,7]])})))()},getUrl:function(){return"http://localhost:8080"}},created:function(){this.fetchAlarms(),this.timer=setInterval(this.fetchAlarms,3e3)}},k=r(128),A=r(124),j=r(130),B=Object(d.a)(O,(function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("v-container",{attrs:{fluid:"","grid-list-xl":"","fill-height":""}},[r("v-layout",{attrs:{"justify-center":"","align-center":""}},[r("v-flex",{attrs:{xs12:""}},[r("material-card",{attrs:{color:"green"}},[r("div",{attrs:{slot:"header"},slot:"header"},[r("div",{staticClass:"title font-weight-light mb-2"},[t._v("Notifications")]),t._v(" "),r("div",{staticClass:"category"},[t._v("\n            List of notifications\n          ")])]),t._v(" "),t._l(t.notifications,(function(e,n){return r("material-notification",{key:n,staticClass:"mb-3",attrs:{color:"warning",dismissible:""}},[r("strong",[t._v("WARNING")]),t._v(" "+t._s(e.fighter)+" - "+t._s(e.co)+" - "+t._s(e.hr)+"\n          ")])}))],2)],1)],1)],1)}),[],!1,null,null,null);e.default=B.exports;v()(B,{VContainer:k.a,VFlex:A.a,VLayout:j.a})}}]);