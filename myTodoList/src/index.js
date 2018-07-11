import App from "./app.vue"
import Vue from "vue";

import './assets/css/global.styl'

const root = document.createElement('div')
document.body.appendChild(root)

new Vue({
  render: h=>h(App)
}).$mount(root)