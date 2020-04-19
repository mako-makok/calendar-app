<template>
    <v-btn tile large color="teal" icon> 
      <v-icon v-if="isLeft">keyboard_arrow_left</v-icon>
      <v-icon v-if="!isLeft">keyboard_arrow_right</v-icon>
    </v-btn>
</template>

<script lang="ts">
import { Vue, Component, Prop } from 'vue-property-decorator'

@Component
export default class BtnArrowLeft extends Vue {
  @Prop()
  public isLeft?: boolean;
}
</script>