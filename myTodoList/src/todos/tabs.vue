<template>
    <div class="tags">
        <span class="left">
            {{getTodosLength}}items left
        </span>
        <span class="middle">
            <span v-for="state in states" 
                :key="state" 
                :class="[state,filter === state?'actived':'']"
                @click="changefilter(state)">
                {{state}}
            </span>
        </span>
        <span class="right" @click="clearCompleted">
            Clear Completed
        </span>
    </div>
</template>

<script>
export default {
  props: {
    todos: {
      type: Array,
      required: true
    },
    filter: {
      type: String,
      required: true
    }
  },
  computed:{
      getTodosLength() {
          return this.todos.filter(ele=>ele.done===false).length;
      }
  },
  data() {
    return {
      states: ["all", "completed", "active"]
    };
  },
  methods: {
      clearCompleted() {
          this.$emit('clear')
      },
      changefilter(state) {
          this.$emit('change',state)
      }
  }
};
</script>

<style lang="stylus" scoped>
    .tags{
        display flex
        justify-content space-between
        font-weight 100
        padding 5px 0
        line-height 30px
        background-color #fff
        font-size 14px
        font-smoothing: antialiased
    }
    .left, .right{
        width 150px
        padding 0 10px
        box-sizing border-box
    }
    .right {
        text-align right 
        cursor pointer
    }
    .middle{
        padding 0 10px
        box-sizing border-box
        display flex
        justify-content space-around
        * {
            display inline-block
            padding 0 10px
            cursor pointer
            border 1px solid rgba(175, 47, 47, 0)
            &.actived{
                border-color rgba(175, 47, 47, 0.4)
                border-radius 5px
            }
        }
    }
</style>


