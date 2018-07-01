<template>
    <div>
        <article>
            <h3>Dodawanie działu:</h3>
            <div>
                <label for="name">Nazwa</label>
                <input id="name" type="text" v-model="department.name">
            </div>
            <div>
                <label for="shortName">Krótka nazwa</label>
                <input id="shortName" type="text" v-model="department.shortName">
            </div>
            <crm-address
                    @updateAddress="updateAddress($event)"
            ></crm-address>
            <div>
                <button type="submit" @click="storeDepartment()">Zapisz</button>
            </div>
        </article>
    </div>
</template>


<script>
    import Address from '../address/Address'
    export default {
        data(){
          return {
              department:{
                  name:'',
                  shortName:'',
                  company_id: this.$route.params.cid,
                  address:{}
              }
          }
        },
        components:{
            'crm-address' : Address
        },
        methods:{
            updateAddress(address){
                this.department.address = address;
            },
            storeDepartment(){
                let vm = this;
               return axios.post('department', this.department)
                   .then(function(response){
                       vm.$router.push({
                           name:'company-single',
                           params:{cid:vm.$route.params.cid}
                       });
                   },
                   function(error){
                        console.log(error);
                   });
            }
        }
    }
</script>

<style scoped>

</style>