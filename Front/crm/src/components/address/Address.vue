<template>
    <section>
        <h3>Dane adresowe</h3>
        <div>
            <label for="city">Miasto:</label>
            <input
                    type="text"
                    id="city"
                    placeholder="np. Gdynia"
                    v-model="address.city"
                    @input="sendData()"
            >
        </div>
        <div>
            <label for="country">Państwo:</label>
            <input type="text"
                   id="country"
                   placeholder="np. Polska"
                   v-model="address.country"
                   @input="sendData()"
            >
        </div>
        <div>
            <label for="zip-code">Kod pocztowy:</label>
            <input
                    type="text"
                    id="zip-code"
                    placeholder="xx-xxx"
                    v-model="address.postal_code"
                    @input="sendData()"
            >
        </div>
        <div>
            <label for="state">Województwo:</label>
            <input
                    type="text"
                    id="state"
                    placeholder="np. Pomorskie"
                    v-model="address.state"
                    @input="sendData()"
            >
        </div>
        <div>
            <label for="street">Ulica:</label>
            <input
                    type="text"
                    id="street"
                    placeholder="np. akacjowa"
                    v-model="address.street"
                    @input="sendData()"
            >
        </div>
        <div>
            <label for="street-number">Nr domu/lokalu:</label>
            <input
                    type="text"
                    id="street-number"
                    placeholder="np. 20/80"
                    v-model="address.street_number"
                    @input="sendData()"
            >
        </div>
    </section>
</template>

<script>
    export default {
        data(){
            return {
                address:{
                    city:'',
                    country:'',
                    postal_code:'',
                    state:'',
                    street:'',
                    street_number:'',
                }
            }
        },
        methods:{
            sendData(){
                this.$emit('updateAddress', this.address);
            }
        }
    }
</script>

<style scoped>

</style>