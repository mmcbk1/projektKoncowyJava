<template>
    <div>
        <article>
            <h3>Dodawanie działu:</h3>
            <div>
                <label for="name">Nazwa</label>
                <input id="name" type="text" v-model="department.name">
            </div>
            <div>
                <label for="shortname">Krótka nazwa</label>
                <input id="shortname" type="text" v-model="department.shortname">
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
                  shortname:'',
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
               return axios.post('department', this.department)
                   .then(function(response){
                       vm.$router.push({
                           name:'company-single',
                           params:{cid:vm.$router.params.cid}
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