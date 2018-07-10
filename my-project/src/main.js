import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

const app = new Vue(App)
app.$mount()

export default {
    config: {
        pages: ['^pages/books/main'],
        "window": {
            "backgroundTextStyle": "light",
            "navigationBarBackgroundColor": "#fff",
            "navigationBarTitleText": "YeMB",
            "navigationBarTextStyle": "light"
        },
        "tabBar": {
            "selectedColor":"red",
            "list": [{
                "iconPath": "pages/me/main",
                "text": "我"
            }, {
                "iconPath": "pages/comments/main",
                "text": "评论"
            }]
        },
    }
}