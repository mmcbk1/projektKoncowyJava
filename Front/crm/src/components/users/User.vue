<template>
    <div>
        <article>
            <section>
                <!--<h3>Nazwa firmy: {{user.department.companyName}}</h3>
                <h2>Nazwa stanowiska: {{user.department.position.name}}</h2>-->
                <div>Imię: {{user.name}}</div>
                <div>Nazwisko: {{user.lastName}}</div>
                <div>E-mail: {{user.email}}</div>
            </section>
            <crm-address-display
                    :address="user.address"
            ></crm-address-display>
            <section class="form-group">
                <textarea class="form-control" placeholder="napisz do mnie.."></textarea>
                <div class="form-group">
                    <button class="btn btn-success">Wyślij</button>
                </div>
            </section>
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
                user: {
                    name: '',
                    lastName: '',
                    email: '',
                    department:{},
                    company: {},
                    address: {},
                }
            }
        },
        methods: {
            getUser() {
                let uid = this.$route.params.uid;
                let vm = this;
                return axios.get('user/'+uid)
                    .then(function (response) {
                            console.log(response.data);
                            vm.user = response.data;
                        },
                        function (error) {

                        })
            },
        },
        created() {
            this.getUser();
        }
    }
</script>

<style scoped>

</style>