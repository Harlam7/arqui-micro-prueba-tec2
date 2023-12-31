PGDMP                  
    {         	   BaseDatos    16.1    16.1 .    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16399 	   BaseDatos    DATABASE     �   CREATE DATABASE "BaseDatos" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE "BaseDatos";
                postgres    false            �            1259    16400    cliente    TABLE     �   CREATE TABLE public.cliente (
    contrasena character varying(255) NOT NULL,
    estado character varying(255) NOT NULL,
    clienteid bigint NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    16422    cuenta    TABLE     �   CREATE TABLE public.cuenta (
    numero_cuenta bigint NOT NULL,
    estado character varying(255),
    saldo_inicial numeric(19,2),
    tipo_cuenta character varying(255)
);
    DROP TABLE public.cuenta;
       public         heap    postgres    false            �            1259    16421    cuenta_numero_cuenta_seq    SEQUENCE     �   CREATE SEQUENCE public.cuenta_numero_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.cuenta_numero_cuenta_seq;
       public          postgres    false    219            �           0    0    cuenta_numero_cuenta_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.cuenta_numero_cuenta_seq OWNED BY public.cuenta.numero_cuenta;
          public          postgres    false    218            �            1259    16431    estado_cuenta    TABLE     
  CREATE TABLE public.estado_cuenta (
    id bigint NOT NULL,
    cliente_id bigint,
    fecha timestamp without time zone,
    numero_cuenta character varying(255) NOT NULL,
    saldo_disponible numeric(10,2),
    saldo_inicial numeric(10,2),
    cuenta_id bigint
);
 !   DROP TABLE public.estado_cuenta;
       public         heap    postgres    false            �            1259    16430    estado_cuenta_id_seq    SEQUENCE     }   CREATE SEQUENCE public.estado_cuenta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.estado_cuenta_id_seq;
       public          postgres    false    221            �           0    0    estado_cuenta_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.estado_cuenta_id_seq OWNED BY public.estado_cuenta.id;
          public          postgres    false    220            �            1259    16438    estado_movimiento    TABLE     �   CREATE TABLE public.estado_movimiento (
    id bigint NOT NULL,
    es_positivo boolean NOT NULL,
    fecha timestamp without time zone,
    monto numeric(19,2),
    tipo character varying(255),
    cuenta_id bigint NOT NULL
);
 %   DROP TABLE public.estado_movimiento;
       public         heap    postgres    false            �            1259    16437    estado_movimiento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.estado_movimiento_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.estado_movimiento_id_seq;
       public          postgres    false    223            �           0    0    estado_movimiento_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.estado_movimiento_id_seq OWNED BY public.estado_movimiento.id;
          public          postgres    false    222            �            1259    16445    movimientos    TABLE     �   CREATE TABLE public.movimientos (
    id bigint NOT NULL,
    fecha timestamp without time zone,
    saldo numeric(19,2),
    tipo_movimiento character varying(255),
    valor numeric(19,2)
);
    DROP TABLE public.movimientos;
       public         heap    postgres    false            �            1259    16444    movimientos_id_seq    SEQUENCE     {   CREATE SEQUENCE public.movimientos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.movimientos_id_seq;
       public          postgres    false    225            �           0    0    movimientos_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.movimientos_id_seq OWNED BY public.movimientos.id;
          public          postgres    false    224            �            1259    16408    persona    TABLE       CREATE TABLE public.persona (
    id bigint NOT NULL,
    direccion character varying(255),
    dtype character varying(255),
    edad integer NOT NULL,
    genero character varying(255),
    nombre character varying(255),
    telefono character varying(255)
);
    DROP TABLE public.persona;
       public         heap    postgres    false            �            1259    16407    persona_id_seq    SEQUENCE     w   CREATE SEQUENCE public.persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.persona_id_seq;
       public          postgres    false    217            �           0    0    persona_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.persona_id_seq OWNED BY public.persona.id;
          public          postgres    false    216            3           2604    16425    cuenta numero_cuenta    DEFAULT     |   ALTER TABLE ONLY public.cuenta ALTER COLUMN numero_cuenta SET DEFAULT nextval('public.cuenta_numero_cuenta_seq'::regclass);
 C   ALTER TABLE public.cuenta ALTER COLUMN numero_cuenta DROP DEFAULT;
       public          postgres    false    218    219    219            4           2604    16434    estado_cuenta id    DEFAULT     t   ALTER TABLE ONLY public.estado_cuenta ALTER COLUMN id SET DEFAULT nextval('public.estado_cuenta_id_seq'::regclass);
 ?   ALTER TABLE public.estado_cuenta ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    221    221            5           2604    16441    estado_movimiento id    DEFAULT     |   ALTER TABLE ONLY public.estado_movimiento ALTER COLUMN id SET DEFAULT nextval('public.estado_movimiento_id_seq'::regclass);
 C   ALTER TABLE public.estado_movimiento ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    223    222    223            6           2604    16448    movimientos id    DEFAULT     p   ALTER TABLE ONLY public.movimientos ALTER COLUMN id SET DEFAULT nextval('public.movimientos_id_seq'::regclass);
 =   ALTER TABLE public.movimientos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            2           2604    16411 
   persona id    DEFAULT     h   ALTER TABLE ONLY public.persona ALTER COLUMN id SET DEFAULT nextval('public.persona_id_seq'::regclass);
 9   ALTER TABLE public.persona ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            �          0    16400    cliente 
   TABLE DATA           @   COPY public.cliente (contrasena, estado, clienteid) FROM stdin;
    public          postgres    false    215   25       �          0    16422    cuenta 
   TABLE DATA           S   COPY public.cuenta (numero_cuenta, estado, saldo_inicial, tipo_cuenta) FROM stdin;
    public          postgres    false    219   b5       �          0    16431    estado_cuenta 
   TABLE DATA           y   COPY public.estado_cuenta (id, cliente_id, fecha, numero_cuenta, saldo_disponible, saldo_inicial, cuenta_id) FROM stdin;
    public          postgres    false    221   �5       �          0    16438    estado_movimiento 
   TABLE DATA           [   COPY public.estado_movimiento (id, es_positivo, fecha, monto, tipo, cuenta_id) FROM stdin;
    public          postgres    false    223   �5       �          0    16445    movimientos 
   TABLE DATA           O   COPY public.movimientos (id, fecha, saldo, tipo_movimiento, valor) FROM stdin;
    public          postgres    false    225   �5       �          0    16408    persona 
   TABLE DATA           W   COPY public.persona (id, direccion, dtype, edad, genero, nombre, telefono) FROM stdin;
    public          postgres    false    217   /6       �           0    0    cuenta_numero_cuenta_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.cuenta_numero_cuenta_seq', 1, false);
          public          postgres    false    218            �           0    0    estado_cuenta_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.estado_cuenta_id_seq', 1, false);
          public          postgres    false    220            �           0    0    estado_movimiento_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.estado_movimiento_id_seq', 1, false);
          public          postgres    false    222            �           0    0    movimientos_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.movimientos_id_seq', 1, false);
          public          postgres    false    224            �           0    0    persona_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.persona_id_seq', 1, false);
          public          postgres    false    216            8           2606    16406    cliente cliente_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (clienteid);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    215            <           2606    16429    cuenta cuenta_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (numero_cuenta);
 <   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pkey;
       public            postgres    false    219            >           2606    16436     estado_cuenta estado_cuenta_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.estado_cuenta
    ADD CONSTRAINT estado_cuenta_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.estado_cuenta DROP CONSTRAINT estado_cuenta_pkey;
       public            postgres    false    221            B           2606    16443 (   estado_movimiento estado_movimiento_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.estado_movimiento
    ADD CONSTRAINT estado_movimiento_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.estado_movimiento DROP CONSTRAINT estado_movimiento_pkey;
       public            postgres    false    223            D           2606    16450    movimientos movimientos_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT movimientos_pkey;
       public            postgres    false    225            :           2606    16415    persona persona_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    217            @           2606    16452 *   estado_cuenta uk_qes5up967aadql4hq8we68mdw 
   CONSTRAINT     n   ALTER TABLE ONLY public.estado_cuenta
    ADD CONSTRAINT uk_qes5up967aadql4hq8we68mdw UNIQUE (numero_cuenta);
 T   ALTER TABLE ONLY public.estado_cuenta DROP CONSTRAINT uk_qes5up967aadql4hq8we68mdw;
       public            postgres    false    221            G           2606    16453 -   estado_movimiento fkfttoemf4sl53o925iwtivxhqr    FK CONSTRAINT     �   ALTER TABLE ONLY public.estado_movimiento
    ADD CONSTRAINT fkfttoemf4sl53o925iwtivxhqr FOREIGN KEY (cuenta_id) REFERENCES public.estado_cuenta(id);
 W   ALTER TABLE ONLY public.estado_movimiento DROP CONSTRAINT fkfttoemf4sl53o925iwtivxhqr;
       public          postgres    false    4670    223    221            E           2606    16416 "   cliente fkltuad7gvir4i2nu5wse9mnb8    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fkltuad7gvir4i2nu5wse9mnb8 FOREIGN KEY (clienteid) REFERENCES public.persona(id);
 L   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fkltuad7gvir4i2nu5wse9mnb8;
       public          postgres    false    4666    217    215            F           2606    16458 )   estado_cuenta fkqd9v6xxm3bg6sa4gj3e91uvqy    FK CONSTRAINT     �   ALTER TABLE ONLY public.estado_cuenta
    ADD CONSTRAINT fkqd9v6xxm3bg6sa4gj3e91uvqy FOREIGN KEY (cuenta_id) REFERENCES public.cuenta(numero_cuenta);
 S   ALTER TABLE ONLY public.estado_cuenta DROP CONSTRAINT fkqd9v6xxm3bg6sa4gj3e91uvqy;
       public          postgres    false    219    221    4668            �       x�3426�tL.�,��4#sS�=... T0�      �   -   x�344442�0�tL.�,K�4400�30�t��/*�/����� ���      �      x������ � �      �      x������ � �      �   F   x�344442�0�4202�54�54Q04�2��25ճ0�454�4450�30�tI-8��8�$�"����� ˲a      �   8   x�344442�0�LN��IUHK�)N���4�����M*J���L��4�S�=... ��     