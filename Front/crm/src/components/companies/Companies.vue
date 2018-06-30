<template>
  <div>
      <router-link tag="li" :to="{name:'users'}">
          <a>Users</a>
      </router-link>
      <router-link tag="li" :to="{name:'users'}">
          <a>Departments</a>
      </router-link>
      <router-view></router-view>
     <ul>
       <li v-for="company in companies">{{company.name}}</li>
     </ul>
  </div>
</template>

<script>

    export default {
        data() {
            return {
                companies:[]
            }
        },
        methods: {
            fetchCompanies() {
                axios.get('companies')
                    .then(function (response) {
                            console.log(respose);
                        },
                        function (error) {

                        })
            }
        }
    }

</script>