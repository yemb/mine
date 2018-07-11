<template>
  <div :class="'head'">
    {{tilte}}
  </div>
</template>

<script>
export default {
  data() {
    return {
      tilte: 'TODOLIST'
    }
  }
}
</script>

<style scoped>
.head{
  text-align: center;
  font-size: 90px;
  line-height: 90px;
  margin:3rem auto;
  color: rgb(28, 208, 231);
}
</style>

