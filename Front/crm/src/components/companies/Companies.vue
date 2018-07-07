<template>
  <div>
      <router-link :to="{name:'company-create'}" tag="li">
          <a>Dodaj firmę</a>
      </router-link>
      <ul>
          <li v-for="company in companies" :key="company.id">
              <router-link tag="a"
                           :to="{
                           name:'company-single', params:{cid:company.id}
                           }">{{company.name}}</router-link>
          </li>
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
                            vm.companies = response.data.content;
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