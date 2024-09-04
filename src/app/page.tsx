export default function Page() {
  return (
    <div className="flex relative justify-between">
      <div className="pt-24 px-16 w-[40%] h-screen flex flex-col items-start justify-start">
        <h1 className="uppercase text-lg mb-2">WELCOME TO EDULENS</h1>
        <h2 className="text-3xl uppercase mb-4">Get Started</h2>
        <p className="mb-4">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse amet
          nulla exercitationem vero commodi, deserunt quo molestiae aliquam
          eligendi explicabo veritatis.
        </p>
        <a
          href="/login"
          className="mt-6 text-center text-lg rounded-full py-3 px-6 font-bold border border-neutral-400 w-full"
        >
          Login
        </a>
      </div>
      <img
        src="/study.svg"
        alt="study"
        className="bottom-0 right-[20%] absolute z-50 pointer-events-none"
      />
      <div className="w-[10%]">
        <img src="/gray.svg" alt="study" className="absolute z-10" />
      </div>

      <div className="bg-[var(--main-color)]  w-[40%] right-[60%]">
        <div className="rotate-90 absolute text-white text-xl ">
          <img src="/text.svg" alt="" className="h-max" />
          <img src="/text.svg" alt="" className="h-full" />
          <img src="/text.svg" alt="" className="h-full" />
        </div>
      </div>
    </div>
  );
}
