const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
    publicPath: './',
  
    devServer: {
  
      host: "0.0.0.0",
  
      port: "9092", // 代理端口
  
    },  
  };