<template>
  <div>
    <div id="cover"></div>
    <div id="ymb">

      <Header></Header>
      <Todo></Todo>
      <!-- <Footer></Footer> -->
    </div>
  </div>

</template>

<script>
import Todo from "./todos/todo.vue";
import Header from "./todos/header.vue";
// import Footer from './todos/footer.vue'

export default {
  components: {
    Todo,
    Header
    // Footer
  },
  data() {
    return {
      test: "yemb"
    };
  }
};
</script>

<style>

#cover{
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  background-color: rgb(148, 146, 146);
  opacity: .8;
  z-index: -1;
}
/* body{
  color:red;
  background-image: url('./assets/images/gua.jpg');
  background-size:50%;
} */
</style>
