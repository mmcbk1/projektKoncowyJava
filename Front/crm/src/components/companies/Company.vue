<template>
    <div>
        <article>
            <section>
                <router-link tag="div" :to="{
                name:'department-create',
                params:{cid:$route.params.cid}
                }">
                    <a>Dodaj dział</a>
                </router-link>
            </section>
            <section>
                <h3>Dane firmy</h3>
                <div>Nazwa {{company.name}}</div>
                <div>NIP {{company.nip}}</div>
                <div>Nr tel {{company.phone_no}}</div>
            </section>
            <section>
                <h3>Dane adresowe</h3>
                <div>Miasto {{company.city}}</div>
                <div>Państwo {{company.country}}</div>
                <div>Kod pocztowy {{company.postal_code}}</div>
                <div>Województwo {{company.state}}</div>
                <div>Nr domu/lokalu {{company.street_number}}</div>
                <div>Ulica {{company.street}}</div>
            </section>
            <section v-if="company.departments.length">
                <h3>Lista działów</h3>
                <ul>
                    <li v-for="department in company.departments" :key="department.id">
                        <router-link :to="{
                        name:'department-single',
                        params:{cid:$route.params.cid, did:department.id}
                        }">{{department.name}}</router-link>
                    </li>
                </ul>
            </section>
        </article>

    </div>
</template>

<script>
    export default {
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
        methods:{
            getCompany(id){
                let vm = this;
               return axios.get('company/'+id)
                    .then(function(response){
                    vm.company = response.data;
                },
                function(error){

                })
            }
        },
        created(){
            this.getCompany(this.$route.params.cid);
        }
    }
</script>

<style scoped>

</style>