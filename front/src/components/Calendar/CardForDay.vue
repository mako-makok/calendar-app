<template>
  <v-card
    class="pa-2"
    max-width="250"
    height="175"
    width="150%"
    tile
    outlined
    @click="startRegistration"
  >
    <div style="text-align: center;">
      {{ day }}
    </div>
    <div style="text-align: center;">
      {{ date }}
    </div>
  </v-card>
</template>

<script lang="ts">
import { Vue, Component, Prop, Emit } from 'vue-property-decorator'

@Component
export default class CardForDay extends Vue {
  @Prop()
  public date!: number

  @Prop()
  public day!: string

  @Emit()
  startRegistration() {
    return this.date + 1
  }
}
</script>
