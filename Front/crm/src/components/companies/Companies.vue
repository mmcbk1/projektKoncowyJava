<template>
    <div>
        <div class="form-group">
            <router-link tag="button" class="btn btn-success" :to="{name:'company-create'}">
                Dodaj firmę
            </router-link>
        </div>
        <section>
            <table class="table table-condensed">
                <thead>
                <th>Nazwa</th>
                <th>NIP</th>
                <th>Telefon</th>
                <th>Ulica</th>
                <th>Kod pocztowy</th>
                <th>Miejscowość</th>
                </thead>
                <tbody>
                <tr v-for="company in companies" :key="company.id" @click="gotToCompany(company.id)">
                    <td>{{company.name | setEmptyChar}}</td>
                    <td>{{company.nip | setEmptyChar}}</td>
                    <td>{{company.phone | setEmptyChar}}</td>
                    <td>
                        <span>{{company.address.street | setEmptyChar}}</span>
                        <span v-if="company.address.street">{{company.address.street_number}}</span>
                    </td>
                    <td>{{company.address.postal_code | setEmptyChar}}</td>
                    <td>{{company.address.city | setEmptyChar}}</td>
                </tr>
                </tbody>
            </table>
        </section>
    </div>
</template>

<script>

    export default {
        data() {
            return {
                companies: []
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
            },
            gotToCompany(id) {
                this.$router.push({
                    name: 'company-single', params: {cid: id}
                })
            }
        },
        created() {
            this.fetchCompanies();
        }
    }

</script>