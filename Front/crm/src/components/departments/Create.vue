<template>
    <article>
        <div class="col-md-3">
            <h3>Dodawanie działu:</h3>
            <div class="form-group">
                <label for="name">Nazwa</label>
                <input class="form-control" id="name" type="text" v-model="department.name">
            </div>
            <div class="form-group">
                <label for="shortName">Krótka nazwa</label>
                <input class="form-control" id="shortName" type="text" v-model="department.shortName">
            </div>
        </div>
        <section class="col-md-3">
            <crm-address
                    @updateAddress="updateAddress($event)"
            ></crm-address>
        </section>
        <div class="clearfix"></div>
        <div class="col-md-6">
            <button class="btn btn-success btn-block" type="submit" @click="storeDepartment()">Zapisz</button>
        </div>

    </article>
</template>


<script>
    import Address from '../address/Address'

    export default {
        data() {
            return {
                department: {
                    name: '',
                    shortName: '',
                    company_id: this.$route.params.cid,
                    address: {}
                }
            }
        },
        components: {
            'crm-address': Address
        },
        methods: {
            updateAddress(address) {
                this.department.address = address;
            },
            storeDepartment() {
                let vm = this;
                return axios.post('department', this.department)
                    .then(function (response) {
                            vm.$router.push({
                                name: 'company-single',
                                params: {cid: vm.$route.params.cid}
                            });
                        },
                        function (error) {
                            console.log(error);
                        });
            }
        }
    }
</script>

<style scoped>

</style>