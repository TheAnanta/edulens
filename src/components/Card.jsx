export default function Card(props) {
  console.log(props.pro);

  return (
    <div className="bg-[var(--secondary-color)] p-6 w-full rounded-3xl items-start justify-start flex flex-col">
      <div>
        <div className="flex flex-col items-center justify-center w-16 h-16 rounded-full bg-[var(--main-color)] text-white">
          {props.title}
        </div>
        <div>
          <p className="text-2xl mt-2 font-semibold">{props.title}</p>
          <p className="text-sm">{props.attribute}</p>
        </div>
      </div>
      <progress value={props.pro} className="mt-4" />
    </div>
  );
}
