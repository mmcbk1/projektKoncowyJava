<template>
    <div>
        <section>
            <h3>Dane adresowe</h3>
            <div>Miasto {{address.city}}</div>
            <div>Państwo {{address.country}}</div>
            <div>Kod pocztowy {{address.postal_code}}</div>
            <div>Województwo {{address.state}}</div>
            <div>Nr domu/lokalu {{address.street_number}}</div>
            <div>Ulica {{address.street}}</div>
        </section>

    </div>
</template>

<script>
    export default {
        props:{
            address: Object,
        }
    }
</script>