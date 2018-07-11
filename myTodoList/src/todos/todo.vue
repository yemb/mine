<template>
  <section class="real-app">
    <input
      class="add-input"
      type="text"
      autofocus="autofocus"
      placeholder="你想干嘛？？"
      @keyup.enter="addTodo"
    />
    <div class="changeSpeed" :style="{'max-height':getheight,'min-height':getheight}">
      <Item
      v-for="todo in nowtodos"
      :key="todo.id"
      :todo="todo"
      @del="deleteTodo"
      @ctododone="changetododone"
    ></Item>
    </div>
    
    <Tabs
    :filter="filter"
    :todos="todos"
    @change="changefilter"
    @clear="clearCompleted"
    ></Tabs>

  </section>
</template>

<script>
import Item from './item.vue'
import Tabs from './tabs.vue'

let id = 1
export default {
  data() {
    return {
      todos:[
        {
          id:1,
          content:'写代码',
          done:false
        }
      ],
      filter:'all'
    }
  },
  components:{
    Item,
    Tabs
  },
  computed:{
    getheight() {
      if(this.filter==='all')
      {
        return this.todos.length*59+'px'
      }
      const completed = this.filter==='completed'
      return this.todos.filter(ele=>ele.done===completed).length*59+'px'
    },
    nowtodos() {
      if(this.filter==='all')
      {
        return this.todos
      }
      const completed = this.filter==='completed'
      return this.todos.filter(ele=>ele.done===completed)
    }
  },
  methods:{
    addTodo(e) {
      const content = e.target.value
      if(content === ''){
        return 
      }
      this.todos.unshift({
        id:id++,
        content:content,
        done:false
      })
      e.target.value = ''
    },
    deleteTodo(id) {
      this.todos.splice(this.todos.findIndex(x=>x.id===id),1)
    },
    changefilter(state) {
      this.filter = state
    },
    clearCompleted() {
      this.todos = this.todos.filter(ele=>!ele.done)
    },
    changetododone(id) {
      this.todos.filter(ele=>ele.id===id).done = !this.todos.filter(ele=>ele.id===id).done 
    }
  }
}  
</script>

<style lang="stylus" scoped>
  .real-app{
    width 600px
    margin 0 auto 
    box-shadow 0 0 5px #666
  }
  .changeSpeed{
    transition all 0.6s ease
  }

  .add-input {
        position: relative;
        margin: 0;
        width: 100%;
        font-size: 24px;
        font-family: inherit;
        font-weight: inherit;
        line-height: 1.4em;
        border: 0;
        outline: none;
        color: inherit;
        padding: 6px;
        border: 1px solid #999;
        box-shadow: inset 0 -1px 5px 0 rgba(0, 0, 0, 0.2);
        box-sizing: border-box;
        font-smoothing: antialiased;
        padding: 16px 16px 16px 60px;
        border: none;
        box-shadow: inset 0 -2px 1px rgba(0, 0, 0, 0.03);
    }

</style>

