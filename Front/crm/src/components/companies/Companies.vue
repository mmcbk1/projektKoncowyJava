<template>
  <div>
      <router-link :to="{name:'company-create'}" tag="li">
          <a>Dodaj firmę</a>
      </router-link>
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
                let vm = this;
               return axios.get('companies')
                    .then(function (response) {
                        console.log(response);
                            vm.companies = response.data;
                        },
                        function (error) {

                        })
            }
        },
        created(){
            this.fetchCompanies();
        }
    }

</script>