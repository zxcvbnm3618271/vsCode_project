import Vue from 'vue'
import VueI18n from 'vue-i18n'

Vue.use(VueI18n)

var language=navigator.language;
console.log(language);
var locale=null;
if(language.toLowerCase()=="zh-cn"){
  locale="zh_cn"
}
else if(language.toLowerCase()=="en-us"){
  locale="en_us"
}
else{
  locale="zh_cn"
}

const i18n = new VueI18n({
  locale: locale,
  messages: {
    'zh_cn': require('@/assets/languages/zh_cn.json'),
    'en_us': require('@/assets/languages/en_us.json')
  }
})

export default i18n
