<template>
    <div>
            <h3>Dane adresowe:</h3>
            <div class="form-group">
                <label for="city">Miasto:</label>
                <input
                        class="form-control"
                        type="text"
                        id="city"
                        placeholder="np. Gdynia"
                        v-model="address.city"
                        @input="sendData()"
                >
            </div>
            <div class="form-group">
                <label for="country">Państwo:</label>
                <input
                        class="form-control"
                        type="text"
                        id="country"
                        placeholder="np. Polska"
                        v-model="address.country"
                        @input="sendData()"
                >
            </div>
            <div class="form-group">
                <label for="zip-code">Kod pocztowy:</label>
                <input
                        class="form-control"
                        type="text"
                        id="zip-code"
                        placeholder="xx-xxx"
                        v-model="address.postal_code"
                        @input="sendData()"
                >
            </div>
            <div class="form-group">
                <label for="state">Województwo:</label>
                <input
                        class="form-control"
                        type="text"
                        id="state"
                        placeholder="np. Pomorskie"
                        v-model="address.state"
                        @input="sendData()"
                >
            </div>
            <div class="form-group">
                <label for="street">Ulica:</label>
                <input
                        class="form-control"
                        type="text"
                        id="street"
                        placeholder="np. akacjowa"
                        v-model="address.street"
                        @input="sendData()"
                >
            </div>
            <div class="form-group">
                <label for="street-number">Nr domu/lokalu:</label>
                <input
                        class="form-control"
                        type="text"
                        id="street-number"
                        placeholder="np. 20/80"
                        v-model="address.street_number"
                        @input="sendData()"
                >
            </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                address: {
                    city: '',
                    country: '',
                    postal_code: '',
                    state: '',
                    street: '',
                    street_number: '',
                }
            }
        },
        methods: {
            sendData() {
                this.$emit('updateAddress', this.address);
            }
        }
    }
</script>

<style scoped>

</style>