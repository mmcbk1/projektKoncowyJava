<template>
    <div>
        <article>
            <section>
                <router-link tag="button" class="btn btn-success" :to="{
                name:'department-create',
                params:{cid:$route.params.cid}
                }">Dodaj dział
                </router-link>

            </section>
            <section>
                <h3>Dane firmy:</h3>
                <div>
                    <label class="my-label">Nazwa:</label> {{company.name}}
                </div>
                <div>
                    <label class="my-label">NIP:</label> {{company.nip}}
                </div>
                <div>
                    <label class="my-label">Nr tel:</label> {{company.phone_no | setEmptyChar}}
                </div>
            </section>

            <section v-if="company.departments.length">
                <h3>Lista działów:</h3>
                <table class="table table-condensed">
                    <thead>
                    <th>Nazwa</th>
                    <th>Krótka nazwa</th>
                    <th>Ulica</th>
                    <th>Kod pocztowy</th>
                    <th>Miejscowość</th>
                    </thead>
                    <tbody>
                    <tr v-for="department in company.departments"
                        :key="department.id"
                        @click="goToDepartment(department.id)">
                        <td>{{department.name | setEmptyChar}}</td>
                        <td>{{department.shortName | setEmptyChar}}</td>
                        <td>
                            <span>{{department.address.street | setEmptyChar}}</span>
                            <span v-if="company.address.street">{{company.address.street_number}}</span>
                        </td>
                        <td>{{department.address.postal_code | setEmptyChar}}</td>
                        <td>{{department.address.city | setEmptyChar}}</td>
                    </tr>
                    </tbody>
                </table>

            </section>
        </article>

    </div>
</template>

<script>
    import AddressDisplay from '../address/AddressDisplay'
    export default {
        comments:{
          'crm-address-display' : AddressDisplay,
        },
        data(){
            return {
                company:{
                    name:'',
                    fax:'',
                    nip:'',
                    phone_no:'',
                    address:{
                        city:'',
                        country:'',
                        postal_code:'',
                        state:'',
                        street_number:'',
                        street:'',
                    },
                    departments:[]
                }
            }
        },
        filters: {
            setEmptyChar(val) {
                if (val) {
                    return val;
                }
                return '-';
            }
        },
        methods:{
            getCompany(id){
                let vm = this;
               return axios.get('company/'+id)
                    .then(function(response){
                    vm.company = response.data;
                },
                function(error){

                })
            },
            goToDepartment(id){
                this.$router.push({
                    name:'department-single',
                    params:{cid:this.$route.params.cid, did:id}
                });
            }
        },
        created(){
            this.getCompany(this.$route.params.cid);
        }
    }
</script>

<style scoped>

</style>