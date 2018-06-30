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
                        v-model="companyData.phone"
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
        <section>
            <h3>Dane adresowe</h3>
            <div>
                <label for="city">Miasto:</label>
                <input
                        type="text"
                        id="city"
                        placeholder="np. Gdynia"
                        v-model="companyData.address.city"
                >
            </div>
            <div>
                <label for="country">Państwo:</label>
                <input type="text"
                       id="country"
                       placeholder="np. Polska"
                       v-model="companyData.address.country"
                >
            </div>
            <div>
                <label for="zip-code">Kod pocztowy:</label>
                <input
                        type="text"
                        id="zip-code"
                        placeholder="xx-xxx"
                        v-model="companyData.address.zipCode"
                >
            </div>
            <div>
                <label for="state">Województwo:</label>
                <input
                        type="text"
                        id="state"
                        placeholder="np. Pomorskie"
                        v-model="companyData.address.state"
                >
            </div>
            <div>
                <label for="street">Ulica:</label>
                <input
                        type="text"
                        id="street"
                        placeholder="np. akacjowa"
                        v-model="companyData.address.street"
                >
            </div>
            <div>
                <label for="street-number">Nr domu/lokalu:</label>
                <input
                        type="text"
                        id="street-number"
                        placeholder="np. 20/80"
                        v-model="companyData.address.streetNumber"
                >
            </div>
        </section>
            <div>
                <button type="submit" @click="storeCompany()">Zapisz</button>
            </div>
        </article>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                companyData:this.initState(),
            }
        },
        methods:{
            initState(){
              return {
                  name:'',
                  nip:'',
                  fax:'',
                  phone: '',
                  address:{
                      city:'',
                      country:'',
                      zipCode:'',
                      state:'',
                      streetNumber:'',
                      street:'',
                  }
              }
            },
            storeCompany(){
                let vm = this;
               return axios.post('company', this.companyData)
                    .then(function(response){
                        vm.initState();
                        vm.$router.push({name:'company'});
                    },function(error){

                    });
            }
        }
    }
</script>

<style scoped>

</style>