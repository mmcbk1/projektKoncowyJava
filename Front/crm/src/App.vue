<template>
  <div>
    <nav class="navbar navbar-default">
      <div class="container">
      <router-link class="navbar-brand"  :to="{name:'companies'}">
        Firmy
      </router-link>
      <router-link class="navbar-brand"  :to="{name:'messages'}">
        Messages <span v-if="notifications > 0" class="badge">{{notifications}}</span>
      </router-link>
      </div>
    </nav>

    <div  class="container jumbotron">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>


export default {
  name: 'app',
    data(){
      return {
          notifications: 0,
      }
    },
    methods:{
      getUnreadNotifications(){
          let vm = this;
         return axios.get('unreadNotifications')
              .then(function(response){
              vm.notification = response.data;
          },
          function(error){

          })
      }
    }
}
</script>
<style>
  .my-label{
    min-width: 60px;
    display: inline-block;
  }
</style>
