<template>
    <div>
        <section>
            <h3>Dane adresowe: </h3>
            <div>
                <label class="my-label">Miasto:</label> {{address.city}}
            </div>
            <div>
                <label class="my-label">Państwo:</label> {{address.country}}
            </div>
            <div>
                <label class="my-label">Kod pocztowy:</label> {{address.postal_code | setEmptyChar}}
            </div>
            <div>
                <label class="my-label">Województwo:</label> {{address.state | setEmptyChar}}
            </div>
            <div>
                <label class="my-label">Nr domu / lokalu:</label> {{address.street_number | setEmptyChar}}
            </div>
            <div>
                <label class="my-label">Ulica:</label> {{address.street | setEmptyChar}}
            </div>
        </section>

    </div>
</template>

<script>
    import {filters} from "../../mixins/filters";

    export default {
        mixins:[filters],
        props:{
            address: Object,
        }
    }
</script>