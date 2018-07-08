<template>
   <div>
       <nav class="navbar navbar-default">
           <router-link class="navbar-brand"  :to="{name:'users-search'}">
             Użytkownicy
           </router-link>
           <router-link class="navbar-brand" :to="{name:'departments-search'}">
              Działy
           </router-link>
       </nav>
       <div>
           <router-view></router-view>
       </div>
   </div>

</template>

<script>
    export default {
        name: "main-nav",
    }
</script>

<style >
    .router-link-active{
        transition: background-color ease .3s;
        background-color: rgba(158, 158, 158, .3) !important;
    }
    .router-link-exact-active{
        transition: background-color ease .3s;
        background-color: rgba(158, 158, 158, .3) !important;
    }
</style>