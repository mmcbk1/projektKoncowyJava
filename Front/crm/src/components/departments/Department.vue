<template>
    <div>
        <article>
            <section>
                <router-link tag="div" :to="{
                name:'user-create',
                params:{cid:$route.params.cid, did:$route.params.cid}
                }">
                    <a>Dodaj usera</a>
                </router-link>
            </section>
            <section>
                <h3>Nazwa firmy: {{department.companyName}}</h3>
                <div>Nazwa {{department.name}}</div>
                <div>Krótka nazwa {{department.shortName}}</div>
            </section>
            <crm-address-display
                    :list="department.users"
                    :address="department.address"
                    listName="List użytkowników"></crm-address-display>
        </article>

    </div>
</template>

<script>
    import AddressDisplay from '../address/AddressDisplay'

    export default {

        components: {
            'crm-address-display': AddressDisplay
        },
        data() {
            return {
                department: {
                    name: '',
                    shortName: '',
                    companyName: '',
                    users: [],
                    address: {},
                    company: {
                        name: ''
                    },
                }
            }
        },
        methods: {
            getDepartment() {
                let did = this.$route.params.did;
                let vm = this;
                return axios.get('department/'+did)
                    .then(function (response) {
                        console.log(response.data);
                            vm.department = response.data;
                        },
                        function (error) {

                        })
            }
        },
        created() {
            this.getDepartment();
        }
    }
</script>

<style scoped>

</style>