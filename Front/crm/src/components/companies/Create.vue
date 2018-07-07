<template>
    <div>
        <article>
            <section>
                <h3>Dane firmy</h3>
                <div>
                    <label for="name">Nazwa:</label>
                    <input
                            type="text"
                            id="name"
                            placeholder="nazwa firmy..."
                            v-model="companyData.name"
                    >
                </div>
                <div>
                    <label for="nip">NIP:</label>
                    <input
                            type="text"
                            id="nip"
                            placeholder=""
                            v-model="companyData.nip"
                    >
                </div>
                <div>
                    <label for="phone">Nr tel:</label>
                    <input
                            type="text"
                            id="phone"
                            placeholder="+48 xxx-xxx-xxx"
                            v-model="companyData.phone_no"
                    >
                </div>
                <div>
                    <label for="fax">Fax:</label>
                    <input
                            type="text"
                            id="fax"
                            placeholder=""
                            v-model="companyData.fax"
                    >
                </div>
            </section>
            <crm-address
                    @updateAddress="updateAddress($event)">
            </crm-address>
            <div>
                <button type="submit" @click="storeCompany()">Zapisz</button>
            </div>
        </article>
    </div>
</template>

<script>
    import Address from '../address/Address';

    export default {
        data() {
            return {
                companyData: this.initState(),
            }
        },
        components: {
            'crm-address': Address
        },
        methods: {
            initState() {
                return {
                    name: '',
                    nip: '',
                    fax: '',
                    phone_no: '',
                    address: {}
                }
            },
            storeCompany() {
                let vm = this;
                return axios.post('company', this.companyData)
                    .then(function (response) {
                        vm.initState();
                        vm.$router.push({name: 'companies'});
                    }, function (error) {

                    });
            },
            updateAddress(address) {
                this.address = address;
            }
        }
    }
</script>

<style scoped>

</style>