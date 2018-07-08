<template>
    <div>
        <article >
            <section class="col-md-3">
                <h3>Dane firmy:</h3>
                <div class="form-group">
                    <label for="name">Nazwa:</label>
                    <input
                            class="form-control"
                            type="text"
                            id="name"
                            placeholder="nazwa firmy..."
                            v-model="companyData.name"
                    >
                </div>
                <div class="form-group">
                    <label for="nip">NIP:</label>
                    <input
                            class="form-control"
                            type="text"
                            id="nip"
                            placeholder=""
                            v-model="companyData.nip"
                    >
                </div>
                <div class="form-group">
                    <label for="phone">Nr tel:</label>
                    <input
                            class="form-control"
                            type="text"
                            id="phone"
                            placeholder="+48 xxx-xxx-xxx"
                            v-model="companyData.phone_no"
                    >
                </div>
                <div class="form-group">
                    <label for="fax">Fax:</label>
                    <input
                            class="form-control"
                            type="text"
                            id="fax"
                            placeholder=""
                            v-model="companyData.fax"
                    >
                </div>
            </section>
            <div class="col-md-3">
                <crm-address
                        @updateAddress="updateAddress($event)">
                </crm-address>
            </div>
            <div class="clearfix"></div>
            <div>
                <div class="col-md-6">
                    <button class="btn btn-block btn-success" type="submit" @click="storeCompany()">Zapisz</button>
                </div>
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